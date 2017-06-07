#include <enunciate-common.c>
#ifndef DEF_food_activities_ext_adapter_ns0_exercise_H
#define DEF_food_activities_ext_adapter_ns0_exercise_H

/**
 * (no documentation provided)
 */
struct food_activities_ext_adapter_ns0_exercise {


  /**
   * (no documentation provided)
   */
  float caloriesPerHour;

  /**
   * (no documentation provided)
   */
  xmlChar *exerciseName;
};

/**
 * Reads a Exercise from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Exercise, or NULL in case of error.
 */
static struct food_activities_ext_adapter_ns0_exercise *xmlTextReaderReadNs0ExerciseType(xmlTextReaderPtr reader);

/**
 * Writes a Exercise to XML.
 *
 * @param writer The XML writer.
 * @param _exercise The Exercise to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0ExerciseType(xmlTextWriterPtr writer, struct food_activities_ext_adapter_ns0_exercise *_exercise);

/**
 * Frees the elements of a Exercise.
 *
 * @param _exercise The Exercise to free.
 */
static void freeNs0ExerciseType(struct food_activities_ext_adapter_ns0_exercise *_exercise);

#endif /* DEF_food_activities_ext_adapter_ns0_exercise_H */
#ifndef DEF_food_activities_ext_adapter_ns0_exercises_H
#define DEF_food_activities_ext_adapter_ns0_exercises_H

/**
 * (no documentation provided)
 */
struct food_activities_ext_adapter_ns0_exercises {


  /**
   * (no documentation provided)
   */
  struct food_activities_ext_adapter_ns0_exercise *exercise;

  /**
   * Size of the exercise array.
   */
  int _sizeof_exercise;
};

/**
 * Reads a Exercises element from XML. The element to be read is "exercises", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The Exercises, or NULL in case of error.
 */
struct food_activities_ext_adapter_ns0_exercises *xml_read_food_activities_ext_adapter_ns0_exercises(xmlTextReaderPtr reader);

/**
 * Writes a Exercises to XML under element name "exercises".
 *
 * @param writer The XML writer.
 * @param _exercises The Exercises to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
int xml_write_food_activities_ext_adapter_ns0_exercises(xmlTextWriterPtr writer, struct food_activities_ext_adapter_ns0_exercises *_exercises);

/**
 * Frees a Exercises.
 *
 * @param _exercises The Exercises to free.
 */
void free_food_activities_ext_adapter_ns0_exercises(struct food_activities_ext_adapter_ns0_exercises *_exercises);

/**
 * Reads a Exercises element from XML. The element to be read is "exercises", and
 * it is assumed that the reader is already pointing to the element.
 *
 * @param reader The XML reader.
 * @return The Exercises, or NULL in case of error.
 */
struct food_activities_ext_adapter_ns0_exercises *xmlTextReaderReadNs0ExercisesElement(xmlTextReaderPtr reader);

/**
 * Writes a Exercises to XML under element name "exercises".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _exercises The Exercises to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0ExercisesElement(xmlTextWriterPtr writer, struct food_activities_ext_adapter_ns0_exercises *_exercises);

/**
 * Writes a Exercises to XML under element name "exercises".
 *
 * @param writer The XML writer.
 * @param _exercises The Exercises to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0ExercisesElementNS(xmlTextWriterPtr writer, struct food_activities_ext_adapter_ns0_exercises *_exercises, int writeNamespaces);

/**
 * Frees the children of a Exercises.
 *
 * @param _exercises The Exercises whose children are to be free.
 */
static void freeNs0ExercisesElement(struct food_activities_ext_adapter_ns0_exercises *_exercises);

/**
 * Reads a Exercises from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Exercises, or NULL in case of error.
 */
static struct food_activities_ext_adapter_ns0_exercises *xmlTextReaderReadNs0ExercisesType(xmlTextReaderPtr reader);

/**
 * Writes a Exercises to XML.
 *
 * @param writer The XML writer.
 * @param _exercises The Exercises to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0ExercisesType(xmlTextWriterPtr writer, struct food_activities_ext_adapter_ns0_exercises *_exercises);

/**
 * Frees the elements of a Exercises.
 *
 * @param _exercises The Exercises to free.
 */
static void freeNs0ExercisesType(struct food_activities_ext_adapter_ns0_exercises *_exercises);

#endif /* DEF_food_activities_ext_adapter_ns0_exercises_H */
#ifndef DEF_food_activities_ext_adapter_ns0_exercise_M
#define DEF_food_activities_ext_adapter_ns0_exercise_M

/**
 * Reads a Exercise from XML. The reader is assumed to be at the start element.
 *
 * @return the Exercise, or NULL in case of error.
 */
static struct food_activities_ext_adapter_ns0_exercise *xmlTextReaderReadNs0ExerciseType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct food_activities_ext_adapter_ns0_exercise *_exercise = calloc(1, sizeof(struct food_activities_ext_adapter_ns0_exercise));



  if (xmlTextReaderIsEmptyElement(reader) == 0) {
    depth = xmlTextReaderDepth(reader);//track the depth.
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);

    while (xmlTextReaderDepth(reader) > depth) {
      if (status < 1) {
        //panic: XML read error.
#if DEBUG_ENUNCIATE
        printf("Failure to advance to next child element.\n");
#endif
        freeNs0ExerciseType(_exercise);
        free(_exercise);
        return NULL;
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "caloriesPerHour", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}caloriesPerHour of type {http://www.w3.org/2001/XMLSchema}float.\n");
#endif
        _child_accessor = xmlTextReaderReadXsFloatType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}caloriesPerHour of type {http://www.w3.org/2001/XMLSchema}float.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0ExerciseType(_exercise);
          free(_exercise);
          return NULL;
        }

        _exercise->caloriesPerHour = *((float*)_child_accessor);
        free(_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "exerciseName", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}exerciseName of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}exerciseName of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0ExerciseType(_exercise);
          free(_exercise);
          return NULL;
        }

        _exercise->exerciseName = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else {
#if DEBUG_ENUNCIATE > 1
        if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
          printf("unknown child element {}%s for type {}exercise.  Skipping...\n",  xmlTextReaderConstLocalName(reader));
        }
        else {
          printf("unknown child element {%s}%s for type {}exercise. Skipping...\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
        }
#endif
        status = xmlTextReaderSkipElement(reader);
      }
    }
  }

  return _exercise;
}

/**
 * Writes a Exercise to XML.
 *
 * @param writer The XML writer.
 * @param _exercise The Exercise to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs0ExerciseType(xmlTextWriterPtr writer, struct food_activities_ext_adapter_ns0_exercise *_exercise) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;
  if (1) { //always write the primitive element.
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "caloriesPerHour", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}caloriesPerHour. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}float for element {}caloriesPerHour...\n");
#endif
    status = xmlTextWriterWriteXsFloatType(writer, &(_exercise->caloriesPerHour));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}float for element {}caloriesPerHour. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}caloriesPerHour. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_exercise->exerciseName != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "exerciseName", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}exerciseName. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}exerciseName...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_exercise->exerciseName));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}exerciseName. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}exerciseName. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }

  return totalBytes;
}

/**
 * Frees the elements of a Exercise.
 *
 * @param _exercise The Exercise to free.
 */
static void freeNs0ExerciseType(struct food_activities_ext_adapter_ns0_exercise *_exercise) {
  int i;
  if (_exercise->exerciseName != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor exerciseName of type food_activities_ext_adapter_ns0_exercise...\n");
#endif
    freeXsStringType(_exercise->exerciseName);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor exerciseName of type food_activities_ext_adapter_ns0_exercise...\n");
#endif
    free(_exercise->exerciseName);
  }
}
#endif /* DEF_food_activities_ext_adapter_ns0_exercise_M */
#ifndef DEF_food_activities_ext_adapter_ns0_exercises_M
#define DEF_food_activities_ext_adapter_ns0_exercises_M

/**
 * Reads a Exercises element from XML. The element to be read is "exercises", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The Exercises, or NULL in case of error.
 */
struct food_activities_ext_adapter_ns0_exercises *xml_read_food_activities_ext_adapter_ns0_exercises(xmlTextReaderPtr reader) {
  int status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
  return xmlTextReaderReadNs0ExercisesElement(reader);
}

/**
 * Writes a Exercises to XML under element name "exercises".
 *
 * @param writer The XML writer.
 * @param _exercises The Exercises to write.
 * @return 1 if successful, 0 otherwise.
 */
int xml_write_food_activities_ext_adapter_ns0_exercises(xmlTextWriterPtr writer, struct food_activities_ext_adapter_ns0_exercises *_exercises) {
  return xmlTextWriterWriteNs0ExercisesElementNS(writer, _exercises, 1);
}

/**
 * Frees a Exercises.
 *
 * @param _exercises The Exercises to free.
 */
void free_food_activities_ext_adapter_ns0_exercises(struct food_activities_ext_adapter_ns0_exercises *_exercises) {
  freeNs0ExercisesType(_exercises);
  free(_exercises);
}

/**
 * Reads a Exercises element from XML. The element to be read is "exercises", and
 * it is assumed that the reader is pointing to that element.
 *
 * @param reader The XML reader.
 * @return The Exercises, or NULL in case of error.
 */
struct food_activities_ext_adapter_ns0_exercises *xmlTextReaderReadNs0ExercisesElement(xmlTextReaderPtr reader) {
  struct food_activities_ext_adapter_ns0_exercises *_exercises = NULL;

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "exercises", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Attempting to read root element {}exercises.\n");
#endif
    _exercises = xmlTextReaderReadNs0ExercisesType(reader);
  }
#if DEBUG_ENUNCIATE
  if (_exercises == NULL) {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      printf("attempt to read {}exercises failed. current element: {}%s\n",  xmlTextReaderConstLocalName(reader));
    }
    else {
      printf("attempt to read {}exercises failed. current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
    }
  }
#endif

  return _exercises;
}

/**
 * Writes a Exercises to XML under element name "exercises".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _exercises The Exercises to write.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0ExercisesElement(xmlTextWriterPtr writer, struct food_activities_ext_adapter_ns0_exercises *_exercises) {
  return xmlTextWriterWriteNs0ExercisesElementNS(writer, _exercises, 0);
}

/**
 * Writes a Exercises to XML under element name "exercises".
 *
 * @param writer The XML writer.
 * @param _exercises The Exercises to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0ExercisesElementNS(xmlTextWriterPtr writer, struct food_activities_ext_adapter_ns0_exercises *_exercises, int writeNamespaces) {
  int totalBytes = 0;
  int status;

  status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "exercises", NULL);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write start element {}exercises. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

#if DEBUG_ENUNCIATE > 1
  printf("writing type {}exercises for root element {}exercises...\n");
#endif
  status = xmlTextWriterWriteNs0ExercisesType(writer, _exercises);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write type for start element {}exercises. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  status = xmlTextWriterEndElement(writer);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to end element {}exercises. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  return totalBytes;
}

/**
 * Frees the children of a Exercises.
 *
 * @param _exercises The Exercises whose children are to be free.
 */
static void freeNs0ExercisesElement(struct food_activities_ext_adapter_ns0_exercises *_exercises) {
  freeNs0ExercisesType(_exercises);
}

/**
 * Reads a Exercises from XML. The reader is assumed to be at the start element.
 *
 * @return the Exercises, or NULL in case of error.
 */
static struct food_activities_ext_adapter_ns0_exercises *xmlTextReaderReadNs0ExercisesType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct food_activities_ext_adapter_ns0_exercises *_exercises = calloc(1, sizeof(struct food_activities_ext_adapter_ns0_exercises));



  if (xmlTextReaderIsEmptyElement(reader) == 0) {
    depth = xmlTextReaderDepth(reader);//track the depth.
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);

    while (xmlTextReaderDepth(reader) > depth) {
      if (status < 1) {
        //panic: XML read error.
#if DEBUG_ENUNCIATE
        printf("Failure to advance to next child element.\n");
#endif
        freeNs0ExercisesType(_exercises);
        free(_exercises);
        return NULL;
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "exercise", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}exercise of type {}exercise.\n");
#endif
        _child_accessor = xmlTextReaderReadNs0ExerciseType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}exercise of type {}exercise.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0ExercisesType(_exercises);
          free(_exercises);
          return NULL;
        }

        _exercises->exercise = realloc(_exercises->exercise, (_exercises->_sizeof_exercise + 1) * sizeof(struct food_activities_ext_adapter_ns0_exercise));
        memcpy(&(_exercises->exercise[_exercises->_sizeof_exercise++]), _child_accessor, sizeof(struct food_activities_ext_adapter_ns0_exercise));
        free(_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else {
#if DEBUG_ENUNCIATE > 1
        if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
          printf("unknown child element {}%s for type {}exercises.  Skipping...\n",  xmlTextReaderConstLocalName(reader));
        }
        else {
          printf("unknown child element {%s}%s for type {}exercises. Skipping...\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
        }
#endif
        status = xmlTextReaderSkipElement(reader);
      }
    }
  }

  return _exercises;
}

/**
 * Writes a Exercises to XML.
 *
 * @param writer The XML writer.
 * @param _exercises The Exercises to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs0ExercisesType(xmlTextWriterPtr writer, struct food_activities_ext_adapter_ns0_exercises *_exercises) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;
  for (i = 0; i < _exercises->_sizeof_exercise; i++) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "exercise", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}exercise. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {}exercise for element {}exercise...\n");
#endif
    status = xmlTextWriterWriteNs0ExerciseType(writer, &(_exercises->exercise[i]));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {}exercise for element {}exercise. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}exercise. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }

  return totalBytes;
}

/**
 * Frees the elements of a Exercises.
 *
 * @param _exercises The Exercises to free.
 */
static void freeNs0ExercisesType(struct food_activities_ext_adapter_ns0_exercises *_exercises) {
  int i;
  if (_exercises->exercise != NULL) {
    for (i = 0; i < _exercises->_sizeof_exercise; i++) {
#if DEBUG_ENUNCIATE > 1
      printf("Freeing accessor exercise[%i] of type food_activities_ext_adapter_ns0_exercises...\n", i);
#endif
      freeNs0ExerciseType(&(_exercises->exercise[i]));
    }
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor exercise of type food_activities_ext_adapter_ns0_exercises...\n");
#endif
    free(_exercises->exercise);
  }
}
#endif /* DEF_food_activities_ext_adapter_ns0_exercises_M */
