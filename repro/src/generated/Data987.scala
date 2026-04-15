package generated

final case class Data987(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data987 = copy(name = name.toUpperCase)
  def scale(k: Double): Data987 = copy(value = value * k)
  def addTag(t: String): Data987 = copy(tags = t :: tags)
  def put(k: String, v: String): Data987 = copy(meta = meta.updated(k, v))
  def merge(other: Data987): Data987 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data987 {
  given Ordering[Data987] = Ordering.by(_.id)
  def empty: Data987 = Data987(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data987 =
    Data987(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data987] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
