package generated

final case class Data1398(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1398 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1398 = copy(value = value * k)
  def addTag(t: String): Data1398 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1398 = copy(meta = meta.updated(k, v))
  def merge(other: Data1398): Data1398 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1398 {
  given Ordering[Data1398] = Ordering.by(_.id)
  def empty: Data1398 = Data1398(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1398 =
    Data1398(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1398] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
