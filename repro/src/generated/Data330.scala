package generated

final case class Data330(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data330 = copy(name = name.toUpperCase)
  def scale(k: Double): Data330 = copy(value = value * k)
  def addTag(t: String): Data330 = copy(tags = t :: tags)
  def put(k: String, v: String): Data330 = copy(meta = meta.updated(k, v))
  def merge(other: Data330): Data330 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data330 {
  given Ordering[Data330] = Ordering.by(_.id)
  def empty: Data330 = Data330(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data330 =
    Data330(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data330] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
