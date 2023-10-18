import React, { useRef } from 'react';

const FocusInput = () => {
    const inputRef = useRef(null);

    const handleButtonClick = () => {
        if (inputRef.current) {
            inputRef.current.focus();
        }
    };

    return (
        <div>
            <input ref={inputRef} type="text" placeholder="Type here" />
            <button onClick={handleButtonClick}>Focus Input</button>
        </div>
    );
};

export default FocusInput;
