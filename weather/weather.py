from xml.etree import cElementTree as ElementTree
import json


def Xml_to_dict(xml_data):
    
    # consider using xml_to_dict
    # convert_xml_to_dictionary is even better
    
    # It is common to use snake case in python and you know it already
    # so please be consistent and apply it throughout all of your works.
    
    # Another reason behind the suggestions of change in the method name:
    # in any programming language, the name of a method or function is always start with verb
    # due to the fact that the function is actually an f(x) which is a mathematical operation
    # we "do" something on the input and it gives us a result.
    
    # One of the biggest strengths of Python is readability
    # always prefer readability over anything else
    # easier to maintain, knowledge transfer etc.
    
    '''
    Change xml tag to dictionary
    :param xml_data: Xml tag data
    :return : Dictionary of data
    '''
    collect_dic = dict()
    if xml_data.items():
        collect_dic.update(dict(xml_data.items()))

    for item in xml_data:
        if item:
            array_tag = two_tag_different(item)
            collect_dic.update({item.tag: array_tag})

        elif item.items():
            collect_dic.update({item.tag: dict(item.items())})
        else:
            collect_dic.update({item.tag: item.text})
    return collect_dic


def two_tag_different(list_items):
    
    # What would other developers guess from its name?
    # Is it checking whether they are different or get a result of two different tags?
    
    # consider using:
    # 1. checking whether they are different: isdifferent
    # 2. get a result: get_different_tags
    
    # whatever, you've got the patterns
    
    '''
    Condition of list items that have to group the data in list together
    '''
    if list_items[0].tag != list_items[1].tag:
        array_tag = Xml_to_dict(list_items)
    else:
        array_tag = {list_items[0].tag: Xml_to_dict(list_items)}

    if list_items.items():
        array_tag.update(dict(list_items.items()))

    return array_tag


def read_file():
    '''
    Read file xml.
    :return: String in file
    '''
    while True:
        input_data = input("Input file xml :")
        try:
            f = open("weather/"+input_data, "r")
            
            # what is f? eventhough we might be able to infer from the context, 
            # it is always better, to be concise.
            
        except FileNotFoundError:
            print("Input file weather.xml")
            
            # The error is file not found, consider using 
            # print("file not found")
            
            # and then we might suggest what the next step the user should take:
            # print("please input weather.xml")
            
            # better UX
            
        else:
            break

    return f.read()


def write_file(weather_json, file_json):
    '''
    Create file json.
    :param weather_json: File output name
    :param file_json: Dictionary data
    :return:
    '''

    f = open("weather/"+file_json, "w+")
    f.write(json.dumps(weather_json, indent=2))


def main():
    temp = read_file()
    root = ElementTree.XML(temp)
    weather_json = Xml_to_dict(root)
    output_data = input("Output file json :")
    write_file(weather_json, output_data)


if __name__ == '__main__':
    main()
    
# It is a good start to create portfolios to show your works

# sometimes it is not about what you can do
# but about what you will be able to do.
# That is why we have what is called "potential".

# Keep on practicing, success will come!

# “Success is not final, failure is not fatal, it is the courage to continue that counts.” 
# — Winston Churchill

