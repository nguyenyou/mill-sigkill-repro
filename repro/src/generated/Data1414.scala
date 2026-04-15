package generated

final case class Data1414(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1414 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1414 = copy(value = value * k)
  def addTag(t: String): Data1414 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1414 = copy(meta = meta.updated(k, v))
  def merge(other: Data1414): Data1414 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1414 {
  given Ordering[Data1414] = Ordering.by(_.id)
  def empty: Data1414 = Data1414(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1414 =
    Data1414(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1414] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
