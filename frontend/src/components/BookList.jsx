//filter books before rendering books as cards

import { useState } from "react";
import { books } from "../books.js";
import SearchBar from "./SearchBar.jsx";
import BookCard from "./Bookcard.jsx";

function BookList() {
    const [filters, setFilters] = useState({ title: "", author: "", category: "" });

    const filteredBooks = books.filter((book) =>
        book.title.toLowerCase().includes(filters.title.toLowerCase()) &&
        book.author.toLowerCase().includes(filters.author.toLowerCase()) &&
        book.category.toLowerCase().includes(filters.category.toLowerCase())
    );

    return (
        <div>
            <SearchBar filters={filters} setFilters={setFilters} />
            <div>
                {filteredBooks.map((book) => (
                    <BookCard key={book.id} book={book} />
                ))}
            </div>
        </div>
    );
}

export default BookList;
