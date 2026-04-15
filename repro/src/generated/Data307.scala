package generated

final case class Data307(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data307 = copy(name = name.toUpperCase)
  def scale(k: Double): Data307 = copy(value = value * k)
  def addTag(t: String): Data307 = copy(tags = t :: tags)
  def put(k: String, v: String): Data307 = copy(meta = meta.updated(k, v))
  def merge(other: Data307): Data307 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data307 {
  given Ordering[Data307] = Ordering.by(_.id)
  def empty: Data307 = Data307(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data307 =
    Data307(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data307] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
