from xml.etree import cElementTree as ElementTree
import json

def Xml_to_dict(xml_data):
    collect_dic = dict()
    if xml_data.items():
        collect_dic.update(dict(xml_data.items()))

    for element in xml_data:
        if element:
            if len(element) == 1 or element[0].tag != element[1].tag:
                array_tag = Xml_to_dict(element)
            else:
                array_tag = {element[0].tag: Xml_to_dict_in_array(element)}

            if element.items():
                array_tag.update(dict(element.items()))
            collect_dic.update({element.tag: array_tag})

        elif element.items():
            collect_dic.update({element.tag: dict(element.items())})
        else:
            collect_dic.update({element.tag: element.text})
    return collect_dic


def Xml_to_dict_in_array(xml_data):

    '''

    :param xml_data:
    :return: List of Dictionary
    '''

    collect_dic = dict()

    if xml_data.items():
        collect_dic.update(dict(xml_data.items()))

        for element in xml_data:
            if element.items():
                collect_dic.update({element.tag: dict(element.items())})
            else:
                collect_dic.update({element.tag: element.text})
    return collect_dic

def read_file(weather):
    f = open("weather/"+weather, "r")
    return f.read()
def write_file(weather_json,file_json):
    f = open("weather/"+file_json, "w+")
    f.write(json.dumps(weather_json, indent=4))

def main():
    input_data = input("Input file xml :")
    temp = read_file(input_data)
    root = ElementTree.XML(temp)
    weather_json = Xml_to_dict(root)
    output_data = input("Output file json :")
    write_file(weather_json,output_data)

if __name__ == '__main__':
    main()


