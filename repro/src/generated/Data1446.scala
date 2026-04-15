package generated

final case class Data1446(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1446 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1446 = copy(value = value * k)
  def addTag(t: String): Data1446 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1446 = copy(meta = meta.updated(k, v))
  def merge(other: Data1446): Data1446 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1446 {
  given Ordering[Data1446] = Ordering.by(_.id)
  def empty: Data1446 = Data1446(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1446 =
    Data1446(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1446] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
