package generated

final case class Data1409(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1409 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1409 = copy(value = value * k)
  def addTag(t: String): Data1409 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1409 = copy(meta = meta.updated(k, v))
  def merge(other: Data1409): Data1409 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1409 {
  given Ordering[Data1409] = Ordering.by(_.id)
  def empty: Data1409 = Data1409(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1409 =
    Data1409(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1409] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
