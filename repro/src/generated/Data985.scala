package generated

final case class Data985(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data985 = copy(name = name.toUpperCase)
  def scale(k: Double): Data985 = copy(value = value * k)
  def addTag(t: String): Data985 = copy(tags = t :: tags)
  def put(k: String, v: String): Data985 = copy(meta = meta.updated(k, v))
  def merge(other: Data985): Data985 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data985 {
  given Ordering[Data985] = Ordering.by(_.id)
  def empty: Data985 = Data985(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data985 =
    Data985(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data985] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
