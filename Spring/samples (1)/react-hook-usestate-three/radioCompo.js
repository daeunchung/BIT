import React, { useState } from "react";

function Radio_compo(){    
    const [radioVal, setRadioVal] = useState("파랑");
    const hChange = (e) => setRadioVal(e.target.value);

    return (
        <div>
            <p>선택된 항목: {radioVal} </p>

            <label>
                <input type="radio" value="빨강" onChange={hChange} checked={radioVal === '빨강'}/>빨강
            </label>
            <label>
                <input type="radio" value="초록" onChange={hChange} checked={radioVal === '초록'}/>초록
            </label>
            <label>
                <input type="radio" value="파랑" onChange={hChange} checked={radioVal === '파랑'}/>파랑
            </label>
        </div>
    );
}

export default Radio_compo;