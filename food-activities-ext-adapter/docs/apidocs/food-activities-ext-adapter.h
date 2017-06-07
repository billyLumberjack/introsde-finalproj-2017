#import "enunciate-common.h"

@class FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises;
@class FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise;

#ifndef DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises_H
#define DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises_H

/**
 * (no documentation provided)
 */
@interface FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises : NSObject <EnunciateXML>
{
  @private
    NSArray *_exercise;
}

/**
 * (no documentation provided)
 */
- (NSArray *) exercise;

/**
 * (no documentation provided)
 */
- (void) setExercise: (NSArray *) newExercise;
@end /* interface FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises */

#endif /* DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercises_H */
#ifndef DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise_H
#define DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise_H

/**
 * (no documentation provided)
 */
@interface FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise : NSObject
{
  @private
    float _caloriesPerHour;
    NSString *_exerciseName;
}

/**
 * (no documentation provided)
 */
- (float) caloriesPerHour;

/**
 * (no documentation provided)
 */
- (void) setCaloriesPerHour: (float) newCaloriesPerHour;

/**
 * (no documentation provided)
 */
- (NSString *) exerciseName;

/**
 * (no documentation provided)
 */
- (void) setExerciseName: (NSString *) newExerciseName;
@end /* interface FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise */

#endif /* DEF_FOOD_ACTIVITIES_EXT_ADAPTERNS0Exercise_H */
