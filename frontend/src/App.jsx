import {Routes, Route, Await} from "react-router-dom";
import Header from "./components/Header.jsx";
import BookList from "./components/BookList.jsx";
import BookDetails from "./components/BookDetails.jsx";
import Order from "./components/Order.jsx";
import {useState} from "react";

function App() {
    const [order, setOrder] = useState([]);

    //add book locally
    const addToOrder = async (book) => {
        setOrder(prev => [...prev, book]);

        //add in backend
        try {
            const res = await fetch("http://localhost:8001/api/orders", {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify({bookId: book.id}),
            });
            if (!res.ok) throw new Error("Failed to add book to backend order");
            const data = await res.json();
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <div>
            <Header/>
            <Routes>
                <Route path={"/"} element={<BookList addToOrder={addToOrder}/>}/>
                <Route path={"/book/:id"} element={<BookDetails addToOrder={{addToOrder}}/>}/>
                <Route path={"/order"} element={<Order order={order}/>}/>
            </Routes>
        </div>
    );
}

export default App;
