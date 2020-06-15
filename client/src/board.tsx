import * as React from 'react';
import {ChangeEvent, useState} from 'react';
import {TaskCreateDTO, TaskDTO, TasksApi} from "../api/generated";
import styled from "styled-components";
import CheckBox from "./molecules/checkbox";

// Propsの型定義
type IProps = {
    name: string;
}

type IState = {
    taskList: Array<Task>;
    newTask: string
}

type Task = {
    id: number,
    title: string,
}

const Board = (props: IProps) => {

    const [taskList, setTaskList] = useState<TaskDTO[]>([]);
    const [newTask, setNewTask] = useState<string>("");
    const [checkedList, setCheckedList] = useState(new Set<number>());
    const showList = () => {
        console.log('クリックされました');
        getTaskList().then(list => {
            if (list) {
                list.forEach(value => console.log(value.id + ":" + value.title));
                setTaskList(list);
            }
        }).catch(err => {
            console.log(err.message);
        });
    }

    const textChange = (e: ChangeEvent<HTMLInputElement>) => {
        setNewTask(e.currentTarget.value);
    }

    const registerButtonClick = () => {
        createTask({title: newTask}).then(() => {
            // todo show toast?
        });
    }

    const handleCheck = (checked: boolean, taskId: number) => {
        updateProgress(taskId, checked).catch((e) => {
            console.log(e);
            // todo checkを元に戻す...？
        });
        if (checked) {
            setCheckedList((prev) => new Set(prev.add(taskId)));
        } else {
            setCheckedList((prev) => {
                prev.delete(taskId);
                return new Set(prev);
            });
        }
    }

    const listTask = (taskList: Array<Task>) => {
        return taskList.map(task => {

            return <StyledDiv>
                <li key={task.id}>
                    <CheckBox key={task.id} checked={checkedList.has(task.id)}
                              onCheck={(checked) => handleCheck(checked, task.id)}/>
                    {task.title}
                </li>
            </StyledDiv>
        });
    }

    const deleteTask = async (id: number) => {
        try {
            await new TasksApi().taskDelete(id);
        } catch (e) {
            console.log(e);
        }
    };

    console.log('render: board');
    return (
        <div>
            <h2>{props.name}</h2>
            <ul>{listTask(taskList)}</ul>
            <button onClick={() => showList()}>表示</button>
            <div>
                <input type="text" onChange={e => textChange(e)}/>
                <button onClick={() => registerButtonClick()}>登録</button>
                <button onClick={() => showList()}>削除</button>
            </div>
        </div>
    );
}

async function getTaskList() {
    try {
        var options = {
            //headers: {'X-SPECIAL-TOKEN': 'aaaaaa'}
        }
        //const response = await new PetsApi().listPets(10);
        const response = await new TasksApi().tasksGet();
        return response.data;
    } catch (error) {
        throw new Error(`Error! HTTP Status: ${error.response}`);
    }
}

// todo move...
async function createTask(taskCreateDTO: TaskCreateDTO) {
    try {
        const response = await new TasksApi().taskPost(taskCreateDTO);
        //const response = await new TasksApi().taskOptions();
        return response.data;
    } catch (error) {
        console.log(error);
        //throw new Error(`Error! HTTP Status: ${error.response}`);
    }
}

const updateProgress = async (taskId: number, isCompleted: boolean) => {
    new TasksApi().putTaskProgress(taskId, isCompleted);
}

const StyledDiv = styled.label`
    display:flex
`
export default Board;
