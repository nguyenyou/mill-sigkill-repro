package generated

final case class Data1401(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1401 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1401 = copy(value = value * k)
  def addTag(t: String): Data1401 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1401 = copy(meta = meta.updated(k, v))
  def merge(other: Data1401): Data1401 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1401 {
  given Ordering[Data1401] = Ordering.by(_.id)
  def empty: Data1401 = Data1401(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1401 =
    Data1401(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1401] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
