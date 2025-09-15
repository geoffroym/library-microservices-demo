import {Link} from "react-router-dom";

function Header() {
    return (
        <header>
            <h1>Bookstore</h1>
            <nav>
                <Link to="/">Home</Link> | <Link to="/order">My Order</Link>
            </nav>
        </header>
    );
}

export default Header;
