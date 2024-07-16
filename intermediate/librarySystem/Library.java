package projects.intermediate.librarySystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book findBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    public void borrowBook(String memberId, String ISBN) {
        Member member = findMemberById(memberId);
        Book book = findBookByISBN(ISBN);
        if (member != null && book != null) {
            member.borrowBook(book);
        } else {
            System.out.println("Member or Book not found.");
        }
    }

    public void returnBook(String memberId, String ISBN) {
        Member member = findMemberById(memberId);
        Book book = findBookByISBN(ISBN);
        if (member != null && book != null) {
            member.returnBook(book);
        } else {
            System.out.println("Member or Book not found.");
        }
    }

    public void listAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getISBN());
            }
        }
    }

    public void listMembers() {
        for (Member member : members) {
            System.out.println("Name: " + member.getName() + ", Member ID: " + member.getMemberId());
        }
    }

    public void saveData(String booksFile, String membersFile) throws IOException {
        try (PrintWriter bookOut = new PrintWriter(new FileWriter(booksFile));
             PrintWriter memberOut = new PrintWriter(new FileWriter(membersFile))) {
            for (Book book : books) {
                bookOut.println(book.toString());
            }
            for (Member member : members) {
                memberOut.println(member.toString());
            }
        }
    }

    public void loadData(String booksFile, String membersFile) throws IOException {
        try (BufferedReader bookIn = new BufferedReader(new FileReader(booksFile));
             BufferedReader memberIn = new BufferedReader(new FileReader(membersFile))) {
            String line;
            while ((line = bookIn.readLine()) != null) {
                books.add(Book.fromString(line));
            }
            while ((line = memberIn.readLine()) != null) {
                members.add(Member.fromString(line));
            }
        }
    }
}
