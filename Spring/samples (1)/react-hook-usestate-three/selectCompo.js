import React, { useState } from "react";

function Select_compo(){
    const [selectedValue, setSelectedValue] = useState("apple");
    const [fruit, setFruit] = useState("");

    const hChange = (e) => setSelectedValue(e.target.value);

    const selectedFruit = () => {
        setFruit(selectedValue);
    }

    return (
        <div>
            <p>선택된 항목: {fruit}</p>

            <select value={selectedValue} onChange={hChange}>
                <option value="apple">사과</option>
                <option value="pear">배</option>
                <option value="banana">바나나</option>
            </select>

            <button type="button" onClick={selectedFruit} >버튼</button>

        </div>
    );
}

export default Select_compo;


