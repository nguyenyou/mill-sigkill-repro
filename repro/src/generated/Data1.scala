package generated

final case class Data1(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1 = copy(value = value * k)
  def addTag(t: String): Data1 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1 = copy(meta = meta.updated(k, v))
  def merge(other: Data1): Data1 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1 {
  given Ordering[Data1] = Ordering.by(_.id)
  def empty: Data1 = Data1(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1 =
    Data1(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1] =
    (1 to n).iterator.map(i => of(i, s"item1$i")).toList
}
