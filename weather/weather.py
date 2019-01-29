from xml.etree import cElementTree as ElementTree
import json

def Xml_to_dict(xml_data):
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

def read_file(weather):
    '''
    Read file xml.
    :param weather: File mane
    :return: String in file
    '''
    f = open("weather/"+weather, "r")
    return f.read()

def write_file(weather_json,file_json):

    '''
    Create file json.
    :param weather_json: File output name
    :param file_json: Dictionary data
    :return:
    '''

    f = open("weather/"+file_json, "w+")
    f.write(json.dumps(weather_json, indent=2))

def main():
    input_data = input("Input file xml :")
    temp = read_file(input_data)
    root = ElementTree.XML(temp)
    weather_json = Xml_to_dict(root)
    output_data = input("Output file json :")
    write_file(weather_json,output_data)

if __name__ == '__main__':
    main()


