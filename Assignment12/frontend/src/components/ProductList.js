import {useState, useEffect} from "react";
import {Link} from "react-router-dom";

import ProductService from "../services/ProductService";

function ProductList() {
    const [products, setProducts] = useState([]);
    const [currentProduct, setCurrentProduct] = useState(null);
    const [currentIndex, setCurrentIndex] = useState(-1);

    useEffect(() => {
        retrieveProducts();
    }, []);


    const retrieveProducts = () => {
        ProductService.getAll()
            .then(response => {
                setProducts(response.data);
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    };

    const refreshList = () => {
        retrieveProducts();
        setCurrentProduct(null);
        setCurrentIndex(-1);
    };

    const setActiveTutorial = (product, index) => {
        setCurrentProduct(product);
        setCurrentIndex(index);
    };



    return (
        <div className="list row">

            <div className="col-md-6">
                <h4>Product List</h4>

                <ul className="list-group">
                    {products &&
                        products.map((s, index) => (
                            <li
                                className={
                                    "list-group-item " + (index === currentIndex ? "active" : "")
                                }
                                onClick={() => setActiveTutorial(s, index)} key={index}
                            >
                                {s.title}, {s.price}, {s.quantity}
                            </li>
                        ))}
                </ul>


            </div>
            <div className="col-md-6">
                {currentProduct ? (
                    <div>
                        <h4>Product</h4>
                        <div>
                            <label>
                                <strong>Title:</strong>
                            </label>{" "}
                            {currentProduct.title}
                        </div>
                        <div>
                            <label>
                                <strong>Price:</strong>
                            </label>{" "}
                            {currentProduct.price}
                        </div>
                        <div>
                            <label>
                                <strong>Quantity:</strong>
                            </label>{" "}
                            {currentProduct.quantity}
                        </div>

                        <Link
                            to={"/products/" + currentProduct.id}
                            className="btn btn-danger"
                        >
                            Edit
                        </Link>
                    </div>
                ) : (
                    <div>
                        <br />
                        <p>Please click on a Product...</p>
                    </div>
                )}
            </div>
        </div>
    );
}

export default ProductList;