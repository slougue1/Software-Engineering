GUIDELINES= [
  {
    "key": "you_guys", 
    "search_terms": ["you guys", "u guys", "uu guys"], 
    "suggestions": ["you", "you all", "y'all"] 
  },
  {
    "key": "man_hours", 
    "search_terms": ["man hours", "woman hours"], 
    "suggestions": ["person hours", "engineer hours"] 
  },
  {
    "key": "grandfathered", 
    "search_terms": ["grandfathered"], 
    "suggestions": ["legacy status"] 
  },
  {
    "key": "dummy_value", 
    "search_terms": [ "dummy value"], 
    "suggestions": ["placeholder value", "sample value"] 
  },
  {
    "key": "dummy_value", 
    "search_terms": [ "dummy value"], 
    "suggestions": ["placeholder value", "sample value"] 
  },
  {
    "key": "sanity_check", 
    "search_terms": ["sanity check"], 
    "suggestions": [ "quick check", "confidence check", "coherence check"]
  }
]


#Match the key argument with a key from the dictionary 
#@arg - key to be checked 
#@return - empty array if the key is not in the guidelines 
#             - array of all suggestion if key in guidelines
def suggestions(key): 
  for one in GUIDELINES: 
    if one["key"] == key:
      return one["suggestions"] 
  return [] 


#Match the key argument with the match argument to see if they are #under the same block of dictionary. If yes, print the message 
#with the appropriate search_terms and suggestions 
#@arg - key to be checked and compared 
#-	index
#-	match, word to be matched with the search_terms
#@return - formatted message with index+ key+ search_terms 
def notice(key, index, match): 
  result= suggestions(key)
  #DUTTER IF- invalidate key 
  #If there are no suggestions return an empty string 
  if (len(result) == 0):
    return ""
  messageSuggestion = ""
  message = ""
  key_l = key
  key_l = key_l.replace("_", "_")
  reference = " Reference https://www.inclusive-styleguide.com/"+ key_l +" for details."

  #DUTTER FOR- suggestions message 
  #loop through the suggestions and append them with "or" untill the last but one for one in range(len(result)-1): 
  messageSuggestion += "'"+result[one] +"' or " 
  messageSuggestion += "'"+result[len(result)-1]+"' ." 
  #DUTTER FOR- are key and macth under the same block? 
  #Search match and key 
  for one in GUIDELINES:
    if one["key"] == key:
      for search in one["search_terms"]:
        if search == match:
          message ="<"+str(index)+"> Consider replacing '"+match+"' with "

  #DUTTER IF- match and key are NOT under the same block #return an empty string 
  if len(message) == 0:
    return 
  return message+messageSuggestion+reference 
    
