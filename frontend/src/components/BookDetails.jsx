import { useParams } from "react-router-dom";
import { books } from "../books.js"
import { useContext } from "react";
import { OrderContext } from "../context/OrderContext.jsx";

function BookDetails() {
    const { id } = useParams();
    const book = books.find((b) => b.id === id);
    const { addToOrder } = useContext(OrderContext);

    if (!book) return <p>Book not found</p>;

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
