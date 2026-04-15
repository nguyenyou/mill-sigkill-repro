package generated

final case class Data1497(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1497 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1497 = copy(value = value * k)
  def addTag(t: String): Data1497 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1497 = copy(meta = meta.updated(k, v))
  def merge(other: Data1497): Data1497 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1497 {
  given Ordering[Data1497] = Ordering.by(_.id)
  def empty: Data1497 = Data1497(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1497 =
    Data1497(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1497] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
