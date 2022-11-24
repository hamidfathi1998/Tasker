package com.vicky7230.tasker.data.db


import com.vicky7230.tasker.data.db.entities.Task
import com.vicky7230.tasker.data.db.entities.TaskList
import com.vicky7230.tasker.data.db.joinReturnTypes.TaskAndTaskList
import com.vicky7230.tasker.data.db.joinReturnTypes.TaskListAndCount
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppDbHelper @Inject constructor(private val appDatabase: AppDatabase) : DbHelper {

    override fun getAllLists(): Flow<List<TaskList>> {
        return appDatabase.tasklistDao().getAllLists()
    }

    override suspend fun getLists(): List<TaskList> {
        return appDatabase.tasklistDao().getLists()
    }

    override fun getAllListsWithTaskCount(): Flow<List<TaskListAndCount>> {
        return appDatabase.tasklistDao().getAllListsWithTaskCount()
    }

    override suspend fun insertTaskLists(taskLists: List<TaskList>): List<Long> {
        return appDatabase.tasklistDao().insertTaskLists(taskLists)
    }

    override suspend fun insertTask(task: Task): Long {
        return appDatabase.taskDao().insertTask(task)
    }

    override suspend fun getTask(taskLongId: Long): Task {
        return appDatabase.taskDao().getTask(taskLongId)
    }

    override fun getTasksForToday(
        todaysDateStart: Long,
        todaysDateEnd: Long
    ): Flow<List<TaskAndTaskList>> {
        return appDatabase.taskDao().getTasksForToday(todaysDateStart, todaysDateEnd)
    }

    override suspend fun updateTask(task: Task): Int {
        return appDatabase.taskDao().updateTask(task)
    }

    override suspend fun insertTasks(tasksAndListFromServer: MutableList<Task>): List<Long> {
        return appDatabase.taskDao().insertTasks(tasksAndListFromServer)
    }

    override fun getTasksForList(listId: Long): Flow<List<Task>> {
        return appDatabase.taskDao().getTasksForList(listId)
    }

    override suspend fun setTaskFinished(id: Long): Int {
        return appDatabase.taskDao().setTaskFinished(id)
    }

    override suspend fun setTaskDeleted(id: Long): Int {
        return appDatabase.taskDao().setTaskDeleted(id)
    }

    override suspend fun updateTaskList(name: String, listId: Long): Int {
        return appDatabase.tasklistDao().updateTaskList(name, listId)
    }

    override suspend fun getDeletedTasks(): List<TaskAndTaskList> {
        return appDatabase.taskDao().getDeletedTasks()
    }

    override suspend fun getFinishedTasks(): List<TaskAndTaskList> {
        return appDatabase.taskDao().getFinishedTasks()
    }

    override suspend fun setListDeleted(id: Long): Int {
        return appDatabase.tasklistDao().setListDeleted(id)
    }

    override suspend fun deleteListAndTasks(lisId: Long): Int {
        return appDatabase.tasklistDao().deleteListAndTasks(lisId)
    }

}