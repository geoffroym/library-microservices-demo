import {useParams} from "react-router-dom";
import {useState, useEffect} from "react";

function BookDetails({addToOrder}) {
    const {id} = useParams();
    const [book, setBook] = useState(null);

    useEffect(() => {
        const fetchBook = async () => {
            try {
                const res = await fetch(`http://localhost:8000/api/books/${id}`);
                if (!res.ok) throw new Error("Book not found");
                const data = await res.json();
                setBook(data);
            } catch (err) {
                console.error(err);
            }
        };
        fetchBook();
    }, [id]);

    if (!book) return <p>Loading book details...</p>;

    return (
        <div>
            <h2>{book.title}</h2>
            <p><strong>Author:</strong> {book.author}</p>
            <p><strong>Category:</strong> {book.category}</p>
            <p>{book.description}</p>
            <button onClick={() => addToOrder(book)}>Add to Order</button>
        </div>
    );
}

export default BookDetails;
