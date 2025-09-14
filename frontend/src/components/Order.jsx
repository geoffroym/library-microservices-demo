//displays books added to order
import { useContext } from "react";
import { OrderContext} from "../context/OrderContext.jsx";

function Order() {
    const { order } = useContext(OrderContext);

    return (
        <div>
            <h2>My Order</h2>
            {order.length === 0 ? (
                <p>No books added yet.</p>
            ) : (
                <ul>
                    {order.map((book, index) => (
                        <li key={index}>{book.title} by {book.author}</li>
                    ))}
                </ul>
            )}
        </div>
    );
}

export default Order;
