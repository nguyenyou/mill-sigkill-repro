package generated

final case class Data11(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data11 = copy(name = name.toUpperCase)
  def scale(k: Double): Data11 = copy(value = value * k)
  def addTag(t: String): Data11 = copy(tags = t :: tags)
  def put(k: String, v: String): Data11 = copy(meta = meta.updated(k, v))
  def merge(other: Data11): Data11 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data11 {
  given Ordering[Data11] = Ordering.by(_.id)
  def empty: Data11 = Data11(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data11 =
    Data11(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data11] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
