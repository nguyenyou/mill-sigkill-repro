package generated

final case class Data856(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data856 = copy(name = name.toUpperCase)
  def scale(k: Double): Data856 = copy(value = value * k)
  def addTag(t: String): Data856 = copy(tags = t :: tags)
  def put(k: String, v: String): Data856 = copy(meta = meta.updated(k, v))
  def merge(other: Data856): Data856 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data856 {
  given Ordering[Data856] = Ordering.by(_.id)
  def empty: Data856 = Data856(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data856 =
    Data856(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data856] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
