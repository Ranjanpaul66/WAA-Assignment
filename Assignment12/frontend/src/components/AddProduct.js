import {useState} from "react";
import ProductService from "../services/ProductService";

export default function AddProduct() {
    const initialProductState = {
        id: null,
        title: "",
        price: 0.0,
        quantity: 0
    };
    const [product, setProduct] = useState(initialProductState);
    const [submitted, setSubmitted] = useState(false);

    const handleInputChange = event => {
        const {name, value} = event.target;
        setProduct({...product, [name]:value});
    }
    const saveProduct = ()=>{
        let data ={
            title: product.title,
            price: product.price,
            quantity: product.quantity
        };
        ProductService.create(data)
            .then( response => {
                setProduct({
                    id: response.id,
                    title: response.title,
                    price: response.price,
                    quantity: response.quantity
                });
                setSubmitted(true);
                console.log(response.data);
            }).catch(e => {
                console.log(e);
            });
    };
    const newProduct = () => {
        setProduct(initialProductState);
        setSubmitted(false);
    };
    return (
        <div className="submit-form">
            {submitted ? (
                <div>
                    <h4>You submitted successfully!</h4>
                    <button className="btn btn-success" onClick={newProduct}>
                        Add
                    </button>
                </div>
            ) : (
                <div>
                    <div className="form-group">
                        <label htmlFor="title">Title</label>
                        <input
                            type="text"
                            className="form-control"
                            id="title"
                            required
                            value={product.title}
                            onChange={handleInputChange}
                            name="title"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="price">Price</label>
                        <input
                            type="text"
                            className="form-control"
                            id="price"
                            required
                            value={product.price}
                            onChange={handleInputChange}
                            name="price"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="quantity">Quantity</label>
                        <input
                            type="text"
                            className="form-control"
                            id="quantity"
                            required
                            value={product.quantity}
                            onChange={handleInputChange}
                            name="quantity"
                        />
                    </div>

                    <button onClick={saveProduct} className="btn btn-success">
                        Submit
                    </button>
                </div>
            )}
        </div>
    );
}