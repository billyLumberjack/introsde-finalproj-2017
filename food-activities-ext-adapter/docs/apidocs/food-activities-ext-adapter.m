#import "food-activities-ext-adapter.h"
#ifndef DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises_M
#define DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises_M

/**
 * (no documentation provided)
 */
@implementation FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises

/**
 * (no documentation provided)
 */
- (NSArray *) exercise
{
  return _exercise;
}

/**
 * (no documentation provided)
 */
- (void) setExercise: (NSArray *) newExercise
{
  [newExercise retain];
  [_exercise release];
  _exercise = newExercise;
}

- (void) dealloc
{
  [self setExercise: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises *_fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises = (FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises *) [FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises (JAXB)

/**
 * Read an instance of FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises *_fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises = [[FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises alloc] init];
  NS_DURING
  {
    [_fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises initWithReader: reader];
  }
  NS_HANDLER
  {
    _fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises autorelease];
  return _fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises;
}

/**
 * Initialize this instance of FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises from an XML reader. The element to be read is
 * "exercises".
 *
 * @param reader The XML reader.
 * @return The FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises *_exercises = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element exercises."];
    }
  }

  if (xmlStrcmp(BAD_CAST "exercises", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}exercises.");
#endif
    _exercises = (FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises *)[FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}exercises.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises. Expected element exercises. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises. Expected element exercises. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _exercises;
}

/**
 * Writes this FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises to XML under element name "exercises".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _exercises The Exercises to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "exercises", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}exercises. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}exercises for root element {}exercises...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}exercises for root element {}exercises...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}exercises. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "exercise", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}exercise of type {}exercise.");
#endif

     __child = [FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}exercise of type {}exercise.");
#endif

    if ([self exercise]) {
      [self setExercise: [[self exercise] arrayByAddingObject: __child]];
    }
    else {
      [self setExercise: [NSArray arrayWithObject: __child]];
    }
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self exercise]) {
    __enumerator = [[self exercise] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "exercise", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}exercise."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}exercise...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}exercise...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}exercise."];
      }
    } //end item iterator.
  }
}
@end /* implementation FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises (JAXB) */

#endif /* DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises_M */
#ifndef DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise_M
#define DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise_M

/**
 * (no documentation provided)
 */
@implementation FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise

/**
 * (no documentation provided)
 */
- (float) caloriesPerHour
{
  return _caloriesPerHour;
}

/**
 * (no documentation provided)
 */
- (void) setCaloriesPerHour: (float) newCaloriesPerHour
{
  _caloriesPerHour = newCaloriesPerHour;
}

/**
 * (no documentation provided)
 */
- (NSString *) exerciseName
{
  return _exerciseName;
}

/**
 * (no documentation provided)
 */
- (void) setExerciseName: (NSString *) newExerciseName
{
  [newExerciseName retain];
  [_exerciseName release];
  _exerciseName = newExerciseName;
}

- (void) dealloc
{
  [self setExerciseName: nil];
  [super dealloc];
}
@end /* implementation FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise (JAXB)

/**
 * Read an instance of FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise *_fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise = [[FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise alloc] init];
  NS_DURING
  {
    [_fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise initWithReader: reader];
  }
  NS_HANDLER
  {
    _fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise autorelease];
  return _fOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise;
}

/**
 * Initialize this instance of FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "caloriesPerHour", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadFloatType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setCaloriesPerHour: *((float*) _child_accessor)];
    free(_child_accessor);
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "exerciseName", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}exerciseName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}exerciseName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setExerciseName: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if (YES) { //always write the primitive element...
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "caloriesPerHour", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}caloriesPerHour."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}caloriesPerHour...");
#endif
    status = xmlTextWriterWriteFloatType(writer, &_caloriesPerHour);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}caloriesPerHour...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}caloriesPerHour."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}caloriesPerHour."];
    }
  }
  if ([self exerciseName]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "exerciseName", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}exerciseName."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}exerciseName...");
#endif
    [[self exerciseName] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}exerciseName...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}exerciseName."];
    }
  }
}
@end /* implementation FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise (JAXB) */

#endif /* DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise_M */
