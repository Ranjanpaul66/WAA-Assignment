import ProductList from "./components/ProductList";
import AddProduct from "./components/AddProduct";
import Product from "./components/Product";
import "./bootstrap/css/bootstrap.min.css";
import {BrowserRouter, Routes, Route, Link} from "react-router-dom";


function App() {


  return (
      <BrowserRouter>
        <div>
          <nav className="navbar navbar-expand navbar-dark bg-dark">
            <a href="/products" className="navbar-brand">
              WAA
            </a>
            <div className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link to={"/products"} className="nav-link">
                  Products
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/add"} className="nav-link">
                  Add
                </Link>
              </li>
            </div>
          </nav>

          <div className="container mt-3">
            <Routes>
              <Route path="/" element={<ProductList/>} />
              <Route path="/products" element={<ProductList/>} />
              <Route path="/add" element={<AddProduct/>} />
              <Route path="/products/:id" element={<Product/>} />
            </Routes>
          </div>
        </div>
      </BrowserRouter>
  );
}

export default App;
