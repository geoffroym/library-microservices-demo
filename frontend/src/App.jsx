import { Routes, Route} from "react-router-dom";
import Header from "./components/Header.jsx";
import BookList from "./components/BookList.jsx";
import BookDetails from "./components/BookDetails.jsx";
import Order from "./components/Order.jsx";

function App() {

    return (
        <div>
            <Header/>
            <Routes>
                <Route path={"/"} element={<BookList/>}/>
                <Route path={"/book/:id"} element={<BookDetails/>}/>
                <Route path={"/orders"} element={<Order/>}/>
            </Routes>
        </div>
    );
}

export default App;
