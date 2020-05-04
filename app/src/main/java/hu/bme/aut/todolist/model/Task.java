/*
 * TodoList API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package hu.bme.aut.todolist.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Task
 */
@Entity
public class Task {
  @PrimaryKey
  @NonNull
  @SerializedName("id")
  private String id = null;

  @ColumnInfo(name = "name")
  @SerializedName("name")
  private String name = null;

  @ColumnInfo(name = "desc")
  @SerializedName("desc")
  private String desc = null;

  @ColumnInfo(name = "dueComplete")
  @SerializedName("dueComplete")
  private Boolean dueComplete = null;



  @Ignore
  @SerializedName("badges")
  private Object badges = null;

  @Ignore
  @SerializedName("checkItemStates")
  private List<String> checkItemStates = null;

  @Ignore
  @SerializedName("closed")
  private Boolean closed = null;

  @Ignore
  @SerializedName("dateLastActivity")
  private String dateLastActivity = null;

  @Ignore
  @SerializedName("descData")
  private Object descData = null;

  @Ignore
  @SerializedName("due")
  private String due = null;

  @Ignore
  @SerializedName("idAttachmentCover")
  private String idAttachmentCover = null;

  @Ignore
  @SerializedName("idBoard")
  private String idBoard = null;

  @Ignore
  @SerializedName("idCheckLists")
  private List<String> idCheckLists = null;

  @Ignore
  @SerializedName("idLabels")
  private List<String> idLabels = null;

  @Ignore
  @SerializedName("idList")
  private String idList = null;

  @Ignore
  @SerializedName("idMembers")
  private List<String> idMembers = null;

  @Ignore
  @SerializedName("idMembersVoted")
  private List<String> idMembersVoted = null;

  @Ignore
  @SerializedName("idShort")
  private Integer idShort = null;

  @Ignore
  @SerializedName("labels")
  private List<Label> labels = null;

  @Ignore
  @SerializedName("manualCoverAttachment")
  private Boolean manualCoverAttachment = null;

  @Ignore
  @SerializedName("pos")
  private Float pos = null;

  @Ignore
  @SerializedName("shortLink")
  private String shortLink = null;

  @Ignore
  @SerializedName("shortUrl")
  private String shortUrl = null;

  @Ignore
  @SerializedName("subscribed")
  private Boolean subscribed = null;

  @Ignore
  @SerializedName("url")
  private String url = null;

  @Ignore
  @SerializedName("address")
  private String address = null;

  @Ignore
  @SerializedName("locationName")
  private String locationName = null;

  @Ignore
  @SerializedName("coordinates")
  private Object coordinates = null;

  public Task(){}

  public Task(String name, String desc) {
    this.name = name;
    this.desc = desc;
    this.setDueComplete(false);
  }

  public Task id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Task badges(Object badges) {
    this.badges = badges;
    return this;
  }

   /**
   * Get badges
   * @return badges
  **/
  public Object getBadges() {
    return badges;
  }

  public void setBadges(Object badges) {
    this.badges = badges;
  }

  public Task checkItemStates(List<String> checkItemStates) {
    this.checkItemStates = checkItemStates;
    return this;
  }

  public Task addCheckItemStatesItem(String checkItemStatesItem) {
    if (this.checkItemStates == null) {
      this.checkItemStates = new ArrayList<String>();
    }
    this.checkItemStates.add(checkItemStatesItem);
    return this;
  }

   /**
   * Get checkItemStates
   * @return checkItemStates
  **/
  public List<String> getCheckItemStates() {
    return checkItemStates;
  }

  public void setCheckItemStates(List<String> checkItemStates) {
    this.checkItemStates = checkItemStates;
  }

  public Task closed(Boolean closed) {
    this.closed = closed;
    return this;
  }

   /**
   * Get closed
   * @return closed
  **/
  public Boolean isClosed() {
    return closed;
  }

  public void setClosed(Boolean closed) {
    this.closed = closed;
  }

  public Task dateLastActivity(String dateLastActivity) {
    this.dateLastActivity = dateLastActivity;
    return this;
  }

   /**
   * Get dateLastActivity
   * @return dateLastActivity
  **/
  public String getDateLastActivity() {
    return dateLastActivity;
  }

  public void setDateLastActivity(String dateLastActivity) {
    this.dateLastActivity = dateLastActivity;
  }

  public Task desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Task descData(Object descData) {
    this.descData = descData;
    return this;
  }

   /**
   * Get descData
   * @return descData
  **/
  public Object getDescData() {
    return descData;
  }

  public void setDescData(Object descData) {
    this.descData = descData;
  }

  public Task due(String due) {
    this.due = due;
    return this;
  }

   /**
   * Get due
   * @return due
  **/
  public String getDue() {
    return due;
  }

  public void setDue(String due) {
    this.due = due;
  }

  public Task dueComplete(Boolean dueComplete) {
    this.dueComplete = dueComplete;
    return this;
  }

   /**
   * Get dueComplete
   * @return dueComplete
  **/
  public Boolean isDueComplete() {
    return dueComplete;
  }

  public void setDueComplete(Boolean dueComplete) {
    this.dueComplete = dueComplete;
  }

  public Task idAttachmentCover(String idAttachmentCover) {
    this.idAttachmentCover = idAttachmentCover;
    return this;
  }

   /**
   * Get idAttachmentCover
   * @return idAttachmentCover
  **/
  public String getIdAttachmentCover() {
    return idAttachmentCover;
  }

  public void setIdAttachmentCover(String idAttachmentCover) {
    this.idAttachmentCover = idAttachmentCover;
  }

  public Task idBoard(String idBoard) {
    this.idBoard = idBoard;
    return this;
  }

   /**
   * Get idBoard
   * @return idBoard
  **/
  public String getIdBoard() {
    return idBoard;
  }

  public void setIdBoard(String idBoard) {
    this.idBoard = idBoard;
  }

  public Task idCheckLists(List<String> idCheckLists) {
    this.idCheckLists = idCheckLists;
    return this;
  }

  public Task addIdCheckListsItem(String idCheckListsItem) {
    if (this.idCheckLists == null) {
      this.idCheckLists = new ArrayList<String>();
    }
    this.idCheckLists.add(idCheckListsItem);
    return this;
  }

   /**
   * Get idCheckLists
   * @return idCheckLists
  **/
  public List<String> getIdCheckLists() {
    return idCheckLists;
  }

  public void setIdCheckLists(List<String> idCheckLists) {
    this.idCheckLists = idCheckLists;
  }

  public Task idLabels(List<String> idLabels) {
    this.idLabels = idLabels;
    return this;
  }

  public Task addIdLabelsItem(String idLabelsItem) {
    if (this.idLabels == null) {
      this.idLabels = new ArrayList<String>();
    }
    this.idLabels.add(idLabelsItem);
    return this;
  }

   /**
   * Get idLabels
   * @return idLabels
  **/
  public List<String> getIdLabels() {
    return idLabels;
  }

  public void setIdLabels(List<String> idLabels) {
    this.idLabels = idLabels;
  }

  public Task idList(String idList) {
    this.idList = idList;
    return this;
  }

   /**
   * Get idList
   * @return idList
  **/
  public String getIdList() {
    return idList;
  }

  public void setIdList(String idList) {
    this.idList = idList;
  }

  public Task idMembers(List<String> idMembers) {
    this.idMembers = idMembers;
    return this;
  }

  public Task addIdMembersItem(String idMembersItem) {
    if (this.idMembers == null) {
      this.idMembers = new ArrayList<String>();
    }
    this.idMembers.add(idMembersItem);
    return this;
  }

   /**
   * Get idMembers
   * @return idMembers
  **/
  public List<String> getIdMembers() {
    return idMembers;
  }

  public void setIdMembers(List<String> idMembers) {
    this.idMembers = idMembers;
  }

  public Task idMembersVoted(List<String> idMembersVoted) {
    this.idMembersVoted = idMembersVoted;
    return this;
  }

  public Task addIdMembersVotedItem(String idMembersVotedItem) {
    if (this.idMembersVoted == null) {
      this.idMembersVoted = new ArrayList<String>();
    }
    this.idMembersVoted.add(idMembersVotedItem);
    return this;
  }

   /**
   * Get idMembersVoted
   * @return idMembersVoted
  **/
  public List<String> getIdMembersVoted() {
    return idMembersVoted;
  }

  public void setIdMembersVoted(List<String> idMembersVoted) {
    this.idMembersVoted = idMembersVoted;
  }

  public Task idShort(Integer idShort) {
    this.idShort = idShort;
    return this;
  }

   /**
   * Get idShort
   * @return idShort
  **/
  public Integer getIdShort() {
    return idShort;
  }

  public void setIdShort(Integer idShort) {
    this.idShort = idShort;
  }

  public Task labels(List<Label> labels) {
    this.labels = labels;
    return this;
  }

  public Task addLabelsItem(Label labelsItem) {
    if (this.labels == null) {
      this.labels = new ArrayList<Label>();
    }
    this.labels.add(labelsItem);
    return this;
  }

   /**
   * Get labels
   * @return labels
  **/
  public List<Label> getLabels() {
    return labels;
  }

  public void setLabels(List<Label> labels) {
    this.labels = labels;
  }

  public Task manualCoverAttachment(Boolean manualCoverAttachment) {
    this.manualCoverAttachment = manualCoverAttachment;
    return this;
  }

   /**
   * Get manualCoverAttachment
   * @return manualCoverAttachment
  **/
  public Boolean isManualCoverAttachment() {
    return manualCoverAttachment;
  }

  public void setManualCoverAttachment(Boolean manualCoverAttachment) {
    this.manualCoverAttachment = manualCoverAttachment;
  }

  public Task name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Task pos(Float pos) {
    this.pos = pos;
    return this;
  }

   /**
   * Get pos
   * @return pos
  **/
  public Float getPos() {
    return pos;
  }

  public void setPos(Float pos) {
    this.pos = pos;
  }

  public Task shortLink(String shortLink) {
    this.shortLink = shortLink;
    return this;
  }

   /**
   * Get shortLink
   * @return shortLink
  **/
  public String getShortLink() {
    return shortLink;
  }

  public void setShortLink(String shortLink) {
    this.shortLink = shortLink;
  }

  public Task shortUrl(String shortUrl) {
    this.shortUrl = shortUrl;
    return this;
  }

   /**
   * Get shortUrl
   * @return shortUrl
  **/
  public String getShortUrl() {
    return shortUrl;
  }

  public void setShortUrl(String shortUrl) {
    this.shortUrl = shortUrl;
  }

  public Task subscribed(Boolean subscribed) {
    this.subscribed = subscribed;
    return this;
  }

   /**
   * Get subscribed
   * @return subscribed
  **/
  public Boolean isSubscribed() {
    return subscribed;
  }

  public void setSubscribed(Boolean subscribed) {
    this.subscribed = subscribed;
  }

  public Task url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Get url
   * @return url
  **/
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Task address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Task locationName(String locationName) {
    this.locationName = locationName;
    return this;
  }

   /**
   * Get locationName
   * @return locationName
  **/
  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public Task coordinates(Object coordinates) {
    this.coordinates = coordinates;
    return this;
  }

   /**
   * Get coordinates
   * @return coordinates
  **/
  public Object getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Object coordinates) {
    this.coordinates = coordinates;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(this.id, task.id) &&
        Objects.equals(this.badges, task.badges) &&
        Objects.equals(this.checkItemStates, task.checkItemStates) &&
        Objects.equals(this.closed, task.closed) &&
        Objects.equals(this.dateLastActivity, task.dateLastActivity) &&
        Objects.equals(this.desc, task.desc) &&
        Objects.equals(this.descData, task.descData) &&
        Objects.equals(this.due, task.due) &&
        Objects.equals(this.dueComplete, task.dueComplete) &&
        Objects.equals(this.idAttachmentCover, task.idAttachmentCover) &&
        Objects.equals(this.idBoard, task.idBoard) &&
        Objects.equals(this.idCheckLists, task.idCheckLists) &&
        Objects.equals(this.idLabels, task.idLabels) &&
        Objects.equals(this.idList, task.idList) &&
        Objects.equals(this.idMembers, task.idMembers) &&
        Objects.equals(this.idMembersVoted, task.idMembersVoted) &&
        Objects.equals(this.idShort, task.idShort) &&
        Objects.equals(this.labels, task.labels) &&
        Objects.equals(this.manualCoverAttachment, task.manualCoverAttachment) &&
        Objects.equals(this.name, task.name) &&
        Objects.equals(this.pos, task.pos) &&
        Objects.equals(this.shortLink, task.shortLink) &&
        Objects.equals(this.shortUrl, task.shortUrl) &&
        Objects.equals(this.subscribed, task.subscribed) &&
        Objects.equals(this.url, task.url) &&
        Objects.equals(this.address, task.address) &&
        Objects.equals(this.locationName, task.locationName) &&
        Objects.equals(this.coordinates, task.coordinates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, badges, checkItemStates, closed, dateLastActivity, desc, descData, due, dueComplete, idAttachmentCover, idBoard, idCheckLists, idLabels, idList, idMembers, idMembersVoted, idShort, labels, manualCoverAttachment, name, pos, shortLink, shortUrl, subscribed, url, address, locationName, coordinates);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    badges: ").append(toIndentedString(badges)).append("\n");
    sb.append("    checkItemStates: ").append(toIndentedString(checkItemStates)).append("\n");
    sb.append("    closed: ").append(toIndentedString(closed)).append("\n");
    sb.append("    dateLastActivity: ").append(toIndentedString(dateLastActivity)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    descData: ").append(toIndentedString(descData)).append("\n");
    sb.append("    due: ").append(toIndentedString(due)).append("\n");
    sb.append("    dueComplete: ").append(toIndentedString(dueComplete)).append("\n");
    sb.append("    idAttachmentCover: ").append(toIndentedString(idAttachmentCover)).append("\n");
    sb.append("    idBoard: ").append(toIndentedString(idBoard)).append("\n");
    sb.append("    idCheckLists: ").append(toIndentedString(idCheckLists)).append("\n");
    sb.append("    idLabels: ").append(toIndentedString(idLabels)).append("\n");
    sb.append("    idList: ").append(toIndentedString(idList)).append("\n");
    sb.append("    idMembers: ").append(toIndentedString(idMembers)).append("\n");
    sb.append("    idMembersVoted: ").append(toIndentedString(idMembersVoted)).append("\n");
    sb.append("    idShort: ").append(toIndentedString(idShort)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    manualCoverAttachment: ").append(toIndentedString(manualCoverAttachment)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    pos: ").append(toIndentedString(pos)).append("\n");
    sb.append("    shortLink: ").append(toIndentedString(shortLink)).append("\n");
    sb.append("    shortUrl: ").append(toIndentedString(shortUrl)).append("\n");
    sb.append("    subscribed: ").append(toIndentedString(subscribed)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

