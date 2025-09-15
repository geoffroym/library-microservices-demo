import {useState, useEffect} from "react";
import SearchBar from "./SearchBar.jsx";
import BookCard from "./Bookcard.jsx";

function BookList({addToOrder}) {
    const [books, setBooks] = useState([]);
    const [filters, setFilters] = useState({title: "", author: "", category: ""});

    useEffect(() => {
        const fetchBooks = async () => {
            try {
                const res = await fetch("http://localhost:8000/api/books");
                const data = await res.json();
                setBooks(data);
            } catch (err) {
                console.error("Error fetching books:",err);
            }
        }
        fetchBooks();
    }, []);

    const filteredBooks = books.filter((book) =>
        book.title.toLowerCase().includes(filters.title.toLowerCase()) &&
        book.author.toLowerCase().includes(filters.author.toLowerCase()) &&
        book.category.toLowerCase().includes(filters.category.toLowerCase())
    );

    return (
        <div>
            <SearchBar filters={filters} setFilters={setFilters}/>
            <div>
                {filteredBooks.map((book) => (
                    <BookCard key={book.id} book={book} addToOrder={addToOrder}/>
                ))}
            </div>
        </div>
    );
}

export default BookList;
