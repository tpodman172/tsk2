import * as React from 'react';
import {ChangeEvent} from 'react';
import styled from "styled-components";

interface Props {
    handleCreateTextChange: (e: ChangeEvent<HTMLInputElement>) => void;
    handleRegister: () => void;
    taskListWithSearch: JSX.Element;
}

const BoardTemplate = ({taskListWithSearch, handleCreateTextChange, handleRegister}: Props) => {
    return <StyledDiv>
        <h2>あさおきたらやることリスト</h2>
        <TasksArea>
            {taskListWithSearch}
        </TasksArea>
        <CreateNewArea>
            <input type="text" onChange={handleCreateTextChange}/>
            <button onClick={handleRegister}>登録</button>
        </CreateNewArea>
    </StyledDiv>;
}
const StyledDiv = styled.div`
    margin-top:12px;
`;
const TasksArea = styled.div`
    margin-top:12px;
`;
const CreateNewArea = styled.div`
    margin-top:12px;
`;

export default BoardTemplate;