import {useNavigate, useParams} from "react-router-dom";
import {useState, useEffect} from "react";
import ProductService from "../services/ProductService";

function Product() {
    const {id} = useParams();
    let navigate = useNavigate();

    const initialProductState = {
        id: null,
        firstName: "",
        lastName: "",
        age: ""
    };
    const [currentProduct, setCurrentProduct] = useState(initialProductState);
    const [message, setMessage] = useState("");

    const getProduct = id => {
        ProductService.get(id)
            .then(response => {
                setCurrentProduct(response.data);
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    };

    useEffect(() => {
        if (id)
            getProduct(id);
    }, [id]);

    const handleInputChange = event => {
        const {name, value} = event.target;
        setCurrentProduct({...currentProduct, [name]: value});
    };

    const updateProduct = () => {
        ProductService.update(currentProduct.id, currentProduct)
            .then(response => {
                console.log('update', response.data);
                setMessage("The tutorial was updated successfully!");
            })
            .catch(e => {
                console.log(e);
            });
    };

    const deleteProduct = () => {
        ProductService.remove(currentProduct.id)
            .then(response => {
                console.log(response.data);
                navigate("/products");
            })
            .catch(e => {
                console.log(e);
            });
    };

    return (

        <div className="edit-form">
            <h4>Product</h4>
            <form>
                <div className="form-group">
                    <label htmlFor="title">Title</label>
                    <input
                        type="text"
                        className="form-control"
                        id="title"
                        name="title"
                        value={currentProduct.title}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="price">Price</label>
                    <input
                        type="text"
                        className="form-control"
                        id="price"
                        name="price"
                        value={currentProduct.price}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="quantity">Quantity</label>
                    <input
                        type="text"
                        className="form-control"
                        id="quantity"
                        name="quantity"
                        value={currentProduct.quantity}
                        onChange={handleInputChange}
                    />
                </div>

            </form>

            <button className="btn btn-danger" onClick={deleteProduct}>
                Delete
            </button>

            <button
                type="submit"
                className="btn btn-danger"
                onClick={updateProduct}
            >
                Update
            </button>
            <p>{message}</p>
        </div>
    );
}

export default Product;