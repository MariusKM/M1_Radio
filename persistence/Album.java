package de.sb.radio.persistence;

public class Album extends BaseEntity {

  char[] title = new char[128];
  short releaseYear;
  byte trackCount;
  Document cover = new Document();
  Track[] tracks;
}
