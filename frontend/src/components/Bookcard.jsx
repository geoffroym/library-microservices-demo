import { Link } from "react-router-dom";

function BookCard({ book }) {
    return (
        <div>
            <h3>{book.title}</h3>
            <p>{book.author}</p>
            <Link to={`/book/${book.id}`}>View Details</Link>
        </div>
    );
}

export default BookCard;
