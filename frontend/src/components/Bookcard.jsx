import {Link} from "react-router-dom";

function BookCard({book, addToOrder}) {
    return (
        <div>
            <h3>{book.title}</h3>
            <p>{book.author}</p>
            <p>{book.category}</p>
            <Link to={`/book/${book.id}`}>View Details</Link>
            <button onClick={() => addToOrder(book)}>Add to Order</button>
        </div>
    );
}

export default BookCard;
