package generated

final case class Data783(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data783 = copy(name = name.toUpperCase)
  def scale(k: Double): Data783 = copy(value = value * k)
  def addTag(t: String): Data783 = copy(tags = t :: tags)
  def put(k: String, v: String): Data783 = copy(meta = meta.updated(k, v))
  def merge(other: Data783): Data783 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data783 {
  given Ordering[Data783] = Ordering.by(_.id)
  def empty: Data783 = Data783(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data783 =
    Data783(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data783] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
