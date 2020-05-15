package hu.bme.aut.todolist.network;

import java.util.List;

import hu.bme.aut.todolist.model.Task;
import retrofit2.Call;
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
   * Create a task
   * Sync method
   * 
   * @param listId ID of list, the task should be added to (required)
   * @param body Create task (required)
   * @param key  (required)
   * @param token  (required)
   * @return Call<Void>
   */
  
  @POST("cards")
  Call<Task> createTask(
    @Query("idList") String listId, @Body Task body, @Query("key") String key, @Query("token") String token
  );

  /**
   * Create a task
   * Async method
   * @param listId ID of list, the task should be added to (required)
   * @param body Create task (required)
   * @param key  (required)
   * @param token  (required)
   * @param cb callback method
   */
  
  @POST("cards")
  Call<Task> createTask(
    @Query("idList") String listId, @Body Task body, @Query("key") String key, @Query("token") String token, Callback<Call<Void>> cb
  );
  /**
   * Deletes a task
   * Sync method
   * 
   * @param cardId Task id to delete (required)
   * @param key  (required)
   * @param token  (required)
   * @return Call<Void>
   */
  
  @DELETE("cards/{cardId}")
  Call<Void> deleteTask(
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
  
  @DELETE("cards/{cardId}")
  Call<Void> deleteTask(
    @Path("cardId") String cardId, @Query("key") String key, @Query("token") String token, Callback<Call<Void>> cb
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
  
  @GET("cards/{cardId}")
  Call<Task> getTaskById(
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
  
  @GET("cards/{cardId}")
  Call<Void> getTaskById(
          @Path("cardId") String cardId, @Query("key") String key, @Query("token") String token, Callback<Task> cb
  );
  /**
   * Get all tasks.
   * Sync method
   * 
   * @param boardId Board object that the cards are on (required)
   * @param key  (required)
   * @param token  (required)
   * @return TaskList
   */
  
  @GET("boards/{boardId}/cards/")
  Call<List<Task>> getTasks(
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
  
  @GET("boards/{boardId}/cards/")
  Call<Void> getTasks(
    @Path("boardId") String boardId, @Query("key") String key, @Query("token") String token, Callback<List<Task>> cb
  );
  /**
   * Updates a task
   * Sync method
   * 
   * @param cardId ID of task to return (required)
   * @param body Updated task (required)
   * @param key  (required)
   * @param token  (required)
   * @return Call<Void>
   */
  
  @PUT("cards/{cardId}")
  Call<Void> updateTask(
          @Path("cardId") String cardId, @Body Task body, @Query("key") String key, @Query("token") String token
  );

  /**
   * Updates a task
   * Async method
   * @param cardId ID of task to return (required)
   * @param body Updated task (required)
   * @param key  (required)
   * @param token  (required)
   * @param cb callback method
   */
  
  @PUT("cards/{cardId}")
  Call<Void> updateTask(
    @Path("cardId") String cardId, @Body Task body, @Query("key") String key, @Query("token") String token, Callback<Call<Void>> cb
  );
}
