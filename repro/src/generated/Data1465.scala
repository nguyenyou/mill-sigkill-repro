package generated

final case class Data1465(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1465 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1465 = copy(value = value * k)
  def addTag(t: String): Data1465 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1465 = copy(meta = meta.updated(k, v))
  def merge(other: Data1465): Data1465 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1465 {
  given Ordering[Data1465] = Ordering.by(_.id)
  def empty: Data1465 = Data1465(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1465 =
    Data1465(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1465] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
