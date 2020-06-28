import * as React from "react";
import styled from "styled-components";

interface Props {
    taskTitle: string;
    checked: boolean;
    onCheck: (checked: boolean) => void;
}

const TaskCard = ({checked, onCheck, taskTitle}: Props) => {
    return (
        <StyledLi
            checked={checked}
            onClick={() => onCheck(!checked)}>
            {taskTitle}
        </StyledLi>
    );
}
const StyledLi = styled.li<{ checked: boolean }>`
    background: ${(props) => props.checked ? 'palevioletred' : 'white'};
    list-style: none;
    height : 100px;
    box-sizing: border-box;
    width: calc(50% - 6px);
    border: solid;
`;

export default TaskCard;
