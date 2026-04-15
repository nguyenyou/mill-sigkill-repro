package generated

final case class Data618(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data618 = copy(name = name.toUpperCase)
  def scale(k: Double): Data618 = copy(value = value * k)
  def addTag(t: String): Data618 = copy(tags = t :: tags)
  def put(k: String, v: String): Data618 = copy(meta = meta.updated(k, v))
  def merge(other: Data618): Data618 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data618 {
  given Ordering[Data618] = Ordering.by(_.id)
  def empty: Data618 = Data618(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data618 =
    Data618(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data618] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
