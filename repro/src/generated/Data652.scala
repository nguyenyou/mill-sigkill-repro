package generated

final case class Data652(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data652 = copy(name = name.toUpperCase)
  def scale(k: Double): Data652 = copy(value = value * k)
  def addTag(t: String): Data652 = copy(tags = t :: tags)
  def put(k: String, v: String): Data652 = copy(meta = meta.updated(k, v))
  def merge(other: Data652): Data652 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data652 {
  given Ordering[Data652] = Ordering.by(_.id)
  def empty: Data652 = Data652(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data652 =
    Data652(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data652] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
