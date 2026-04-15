package generated

final case class Data1485(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1485 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1485 = copy(value = value * k)
  def addTag(t: String): Data1485 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1485 = copy(meta = meta.updated(k, v))
  def merge(other: Data1485): Data1485 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1485 {
  given Ordering[Data1485] = Ordering.by(_.id)
  def empty: Data1485 = Data1485(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1485 =
    Data1485(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1485] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
