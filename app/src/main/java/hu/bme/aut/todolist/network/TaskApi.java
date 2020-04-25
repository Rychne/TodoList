package hu.bme.aut.todolist.network;

import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.model.TaskList;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TaskApi {

  /**
   * Get all tasks.
   * Sync method
   *
   * @param boardId Board object that the cards are on (required)
   * @param key  (required)
   * @param token  (required)
   * @return TaskList
   */

  @GET("/boards/{boardId}/cards/")
  TaskList getTasks(
          @Path("boardId") String boardId, @Query("key") String key, @Query("token") String token
  );

  /**
   * Get all tasks.
   * Async method
   * @param boardId Board object that the cards are on (required)
   * @param key  (required)
   * @param token  (required)
   * @param cb callback method
   */

  @GET("/boards/{boardId}/cards/")
  void getTasks(
          @Path("boardId") String boardId, @Query("key") String key, @Query("token") String token, Callback<TaskList> cb
  );

  /**
   * Create a task
   * Sync method
   * 
   * @param listId ID of list to add the task to (required)
   * @param body create task (required)
   * @return Void
   */
  
  @POST("/cards")
  Void createTask(
          @Path("listId") String listId, @Body Task body
  );

  /**
   * Create a task
   * Async method
   * @param listId ID of list to add task to (required)
   * @param body Updated task (required)
   * @param cb callback method
   */
  
  @POST("/cards")
  void createTask(
          @Path("listId") String listId, @Body Task body, Callback<Void> cb
  );
  /**
   * Deletes a task
   * Sync method
   * 
   * @param cardId Task id to delete (required)
   * @param key  (required)
   * @param token  (required)
   * @return Void
   */
  
  @DELETE("/cards/{cardId}")
  Void deleteTask(
          @Path("cardId") String cardId, @Query("key") String key, @Query("token") String token
  );

  /**
   * Deletes a task
   * Async method
   * @param cardId Task id to delete (required)
   * @param key  (required)
   * @param token  (required)
   * @param cb callback method
   */
  
  @DELETE("/cards/{cardId}")
  void deleteTask(
          @Path("cardId") String cardId, @Query("key") String key, @Query("token") String token, Callback<Void> cb
  );
  /**
   * Find task by ID
   * Sync method
   * Returns a single task
   * @param cardId ID of task to return (required)
   * @param key  (required)
   * @param token  (required)
   * @return Task
   */
  
  @GET("/cards/{cardId}")
  Task getTaskById(
          @Path("cardId") String cardId, @Query("key") String key, @Query("token") String token
  );

  /**
   * Find task by ID
   * Async method
   * @param cardId ID of task to return (required)
   * @param key  (required)
   * @param token  (required)
   * @param cb callback method
   */
  
  @GET("/cards/{cardId}")
  void getTaskById(
          @Path("cardId") String cardId, @Query("key") String key, @Query("token") String token, Callback<Task> cb
  );
  /**
   * Updates a task
   * Sync method
   * 
   * @param cardId ID of task to return (required)
   * @param body Updated task (required)
   * @return Void
   */
  
  @PUT("/cards/{cardId}")
  Void updateTask(
          @Path("cardId") String cardId, @Body Task body
  );

  /**
   * Updates a task
   * Async method
   * @param cardId ID of task to return (required)
   * @param body Updated task (required)
   * @param cb callback method
   */
  
  @PUT("/cards/{cardId}")
  void updateTask(
          @Path("cardId") String cardId, @Body Task body, Callback<Void> cb
  );
}
