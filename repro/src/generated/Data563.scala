package generated

final case class Data563(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data563 = copy(name = name.toUpperCase)
  def scale(k: Double): Data563 = copy(value = value * k)
  def addTag(t: String): Data563 = copy(tags = t :: tags)
  def put(k: String, v: String): Data563 = copy(meta = meta.updated(k, v))
  def merge(other: Data563): Data563 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data563 {
  given Ordering[Data563] = Ordering.by(_.id)
  def empty: Data563 = Data563(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data563 =
    Data563(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data563] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
